import data.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPostIdNotZero() {
        val post = Post(0, 1, 1, null, 1627884000, "Test Post", null, null, false,
            Comments(0, true, true, true, true),
            Likes(0, false, true, true),
            Reposts(0, false),
            Views(0),
            "post", null, null, null, null, true,
            true, true, false, false, false,
            null, 0)
        val addedPost = WallService.addPost(post)
        assertTrue(addedPost.id != 0)
    }

    @Test
    fun updateExistingPost() {
        val post = WallService.addPost(Post(0, 1, 1, null, 1627884000, "Test Post", null, null, false,
            Comments(0, true, true, true, true),
            Likes(0, false, true, true),
            Reposts(0, false),
            Views(0),
            "post", null, null, null, null, true,
            true, true, false, false, false,
            null, 0))
        val updatedPost = post.copy(text = "Updated Post")
        assertTrue(WallService.updatePost(updatedPost))
    }

    @Test
    fun updateNonExistingPost() {
        val update = Post(999, 1, 1, null, 1627884000, "Non-existing Post", null, null, false,
            Comments(0, true, true, true, true),
            Likes(0, false, true, true),
            Reposts(0, false),
            Views(0),
            "post", null, null, null, null, true,
            true, true, false, false, false,
            null, 0)
        assertFalse(WallService.updatePost(update))
    }
}
