package com.example.caretones.RoomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PessoaDao {

    @Upsert
    suspend fun upsertPessoa(pessoa: Pessoa)

    @Update
    suspend fun updatePessoa(pessoa: Pessoa)

    @Delete
    suspend fun deletePessoa(pessoa: Pessoa)

    @Query("SELECT * FROM Pessoa")
    fun getAllPessoa(): Flow<List<Pessoa>>

    @Query("SELECT * FROM Pessoa WHERE email = :email AND senha = :senha")
    suspend fun login(email: String, senha: String): List<Pessoa>

    @Query("SELECT * FROM Pessoa WHERE email = :email")
    suspend fun testarEmail(email: String): List<Pessoa>

    @Query("SELECT * FROM Pessoa WHERE logado = true")
    suspend fun testarLogin(): List<Pessoa>

    @Query("SELECT * FROM Pessoa WHERE logado = true")
    suspend fun testarNome(): List<Pessoa>

    @Query("SELECT * FROM pessoa WHERE idCliente = :idCliente")
    suspend fun getIdCliente(idCliente: Int): List<Pessoa>

}