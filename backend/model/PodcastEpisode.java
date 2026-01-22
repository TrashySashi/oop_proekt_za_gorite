@Entity
public class PodcastEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String audioUrl;
    private LocalDate uploadDate;

    public PodcastEpisode() {}

    public PodcastEpisode(String title, String description, String audioUrl) {
        this.title = title;
        this.description = description;
        this.audioUrl = audioUrl;
        this.uploadDate = LocalDate.now();
    }

    // getters and setters
}
