package com.example.zemogatest.database.dao

import androidx.room.*
import com.example.zemogatest.database.entity.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM post_table ORDER BY favorite DESC")
    suspend fun getPosts(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)

    @Query("DELETE FROM post_table")
    suspend fun deletePosts()

    @Query("UPDATE post_table SET favorite = 1 WHERE id = :postId")
    suspend fun addPostToFavorites(postId: Int): Int

    @Query("UPDATE post_table SET favorite = 0 WHERE id = :postId")
    suspend fun removePostFromFavorites(postId: Int): Int

}
