@RestController
@RequestMapping("/api/comments")
@CrossOrigin
public class CommentController {

    private final CommentRepository repo;
    private final UserRepository userRepo;

    public CommentController(CommentRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @GetMapping("/{episodeId}")
    public List<Comment> getComments(@PathVariable int episodeId) {
        return repo.findByEpisodeId(episodeId);
    }

    @PostMapping("/{episodeId}")
    public Comment addComment(
            @PathVariable int episodeId,
            @RequestBody String content,
            Principal principal) {

        User user = userRepo.findByUsername(principal.getName()).orElseThrow();
        return repo.save(new Comment(content, user, episodeId));
    }
}
