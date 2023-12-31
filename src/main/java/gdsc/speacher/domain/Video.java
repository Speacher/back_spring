package gdsc.speacher.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Video extends BaseEntity{

    //private String baseUrl = "https://video-ex.s3.ap-northeast-2.amazonaws.com/"; // 기본 URL

    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Lob
    @Column(name = "video_url", columnDefinition = "TEXT")
    private String videoUrl;

    private String title;


    @OneToOne(mappedBy = "video", cascade = CascadeType.ALL)
    private CV cv;

    @OneToOne(mappedBy = "video", cascade = CascadeType.ALL)
    private NLP nlp;

    @OneToOne(mappedBy = "video", cascade = CascadeType.ALL)
    private GPT gpt;

    public Video(Member member, String videoUrl, String title) {
        this.member = member;
        this.videoUrl = videoUrl;
        this.title = title;
    }
}
