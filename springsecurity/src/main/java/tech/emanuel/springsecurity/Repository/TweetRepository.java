package tech.emanuel.springsecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.emanuel.springsecurity.Entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
