package xyz.moonsod.youtubevideosearch.obj;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.moonsod.youtubevideosearch.obj.model.video.VideoRoot;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GoogleAPI {
    protected final String secret;
    private final String SEARCH_URL;
    private final HttpClient httpClient;

    public GoogleAPI(String secret) {
        this.secret = secret;

        httpClient = HttpClient.newHttpClient();
        SEARCH_URL = String.format("https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=$max$&q=$query$&key=%s", secret);
    }

    public List<VideoEntry> getVideos(String query, int maxResults) {
        List<VideoEntry> videos = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder(URI.create(
                SEARCH_URL
                        .replaceAll("\\$query\\$", query)
                        .replaceAll("\\$max\\$", String.valueOf(maxResults))
        ))
                .header("accept", "application/json")
                .build();

        try {
            ObjectMapper mapper = new ObjectMapper();

            HttpResponse<String> res = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            VideoRoot root = mapper.readValue(res.body(), VideoRoot.class);

            root.items.forEach(videoItem -> videos.add(new VideoEntry(videoItem.snippet.title, videoItem.snippet.channelTitle)));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return videos;
    }

}
