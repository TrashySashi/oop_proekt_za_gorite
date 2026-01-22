public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByEpisodeId(int episodeId);
}
