package com.example.caretones.viewModel

import com.example.caretones.RoomDB.Pessoa
import com.example.caretones.RoomDB.PessoaDataBase

class Repository(private val db: PessoaDataBase?) {
    suspend fun  upsertPessoa(pessoa: Pessoa){
        db?.pessoaDao()?.upsertPessoa(pessoa)
    }

    suspend fun  updatePessoa(pessoa: Pessoa){
        db?.pessoaDao()?.updatePessoa(pessoa)
    }

    suspend fun  deletePessoa(pessoa: Pessoa){
        db?.pessoaDao()?.deletePessoa(pessoa)
    }

    suspend fun  login(email: String, senha: String): List<Pessoa>? {
        return db?.pessoaDao()?.login(email, senha)
    }

    suspend fun  testarEmail(email: String): List<Pessoa>? {
        return db?.pessoaDao()?.testarEmail(email)
    }

    suspend fun  testarNome(email: String): List<Pessoa>? {
        return db?.pessoaDao()?.testarEmail(email)
    }

    suspend fun getIdPessoa(idPessoa: Int): List<Pessoa>? {
        return db?.pessoaDao()?.getIdCliente(idPessoa)
    }

    suspend fun testarLogin(): List<Pessoa>?{
        return db?.pessoaDao()?.testarLogin()
    }

    fun getAllPessoa() = db?.pessoaDao()?.getAllPessoa()

}
