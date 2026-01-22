@RestController
@RequestMapping("/api/podcasts")
@CrossOrigin
public class PodcastController {

    private final PodcastManager manager;

    public PodcastController(PodcastManager manager) {
        this.manager = manager;
    }

    @GetMapping
    public List<PodcastEpisode> all() {
        return manager.getAllEpisodes();
    }

    @PostMapping
    public PodcastEpisode add(@RequestBody PodcastEpisode ep) {
        return manager.addEpisode(ep);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        manager.removeEpisode(id);
    }
}
