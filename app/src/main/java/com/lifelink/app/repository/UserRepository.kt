package com.lifelink.app.repository

import com.lifelink.app.dao.UserDao
import com.lifelink.app.entities.User

/**
 * Single source of truth for user authentication data. Wraps [UserDao] so
 * ViewModels never talk to Room directly (Repository Pattern).
 */
class UserRepository(private val userDao: UserDao) {

    suspend fun register(user: User): Result<Long> {
        return try {
            if (userDao.countByEmail(user.email) > 0) {
                Result.failure(Exception("An account with this email already exists"))
            } else {
                Result.success(userDao.insertUser(user))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun login(email: String, password: String): Result<User> {
        return try {
            val user = userDao.login(email, password)
            if (user != null) Result.success(user)
            else Result.failure(Exception("Invalid email or password"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserById(id: Int): User? = userDao.getUserById(id)

    suspend fun updateUser(user: User): Result<Unit> {
        return try {
            userDao.updateUser(user)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
