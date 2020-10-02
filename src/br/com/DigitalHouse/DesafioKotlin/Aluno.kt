package br.com.DigitalHouse.DesafioKotlin

//PARTE A - Classe Aluno
data class Aluno (var nomeAluno: String, var sobrenomeAluno: String, var codigoAluno: Int){

    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (codigoAluno == other.codigoAluno)
    }

}