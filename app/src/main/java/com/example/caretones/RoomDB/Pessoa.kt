package com.example.caretones.RoomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pessoa(
    val email: String,
    val senha: String,
    var nome: String,
    val datansc: String,
    val cpf: String,
    var telefone: String,
    var endereco: String,
    var logado: Boolean = false,

    @PrimaryKey(autoGenerate = true)
    val idCliente: Int = 0
)