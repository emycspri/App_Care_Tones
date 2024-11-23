package com.example.caretones.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.caretones.RoomDB.Pessoa
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

open class PessoaViewModel(private val repository: Repository) : ViewModel() {
    fun getPessoa() = repository.getAllPessoa()?.asLiveData(viewModelScope.coroutineContext)

    fun upsertPessoa(pessoa: Pessoa) {
        viewModelScope.launch{
            repository.upsertPessoa(pessoa)
        }
    }

    fun updatePessoa(pessoa: Pessoa) {
        viewModelScope.launch{
            repository.updatePessoa(pessoa)
        }
    }

    fun deletePessoa(pessoa: Pessoa) {
        viewModelScope.launch{
            repository.deletePessoa(pessoa)
        }
    }

    suspend fun loginPessoa(email: String, senha: String): List<Pessoa> {
        val deferred: Deferred<List<Pessoa>> = viewModelScope.async {
            repository.login(email, senha)!!
        }
        return deferred.await()
    }

    suspend fun testarEmail(email: String):List<Pessoa>{
        val deferred: Deferred<List<Pessoa>> = viewModelScope.async {
            repository.testarEmail(email)!!
        }
        return deferred.await()

    }

    suspend fun testarLogin():List<Pessoa> {
        val deferred: Deferred<List<Pessoa>> = viewModelScope.async {
            repository.testarLogin()!!
        }
        return deferred.await()
    }

    suspend fun getIdPessoa(idPessoa: Int): List<Pessoa> {
        val deferred: Deferred<List<Pessoa>> = viewModelScope.async {
            repository.getIdPessoa(idPessoa)!!
        }
        return deferred.await()
    }
}

