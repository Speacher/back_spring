package gdsc.speacher.feedback.dto;

import gdsc.speacher.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto {

    private String title;
    private String videoUrl;

    public VideoDto(Video video) {
        this.title = video.getTitle();
        this.videoUrl = video.getVideoUrl();
    }
}