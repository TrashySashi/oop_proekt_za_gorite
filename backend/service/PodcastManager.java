@Service
public class PodcastManager {

    private final PodcastEpisodeRepository repo;

    public PodcastManager(PodcastEpisodeRepository repo) {
        this.repo = repo;
    }

    public PodcastEpisode addEpisode(PodcastEpisode ep) {
        return repo.save(ep);
    }

    public void removeEpisode(int id) {
        repo.deleteById(id);
    }

    public List<PodcastEpisode> getAllEpisodes() {
        return repo.findAll();
    }
}
