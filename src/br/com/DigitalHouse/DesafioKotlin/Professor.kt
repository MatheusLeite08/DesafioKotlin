package br.com.DigitalHouse.DesafioKotlin

//PARTE C - Classe Professor
//ProfessorTitular --> other = especialização
//ProfessorAdjunto --> other = horasMonitorias
data class Professor (var nomeProfessor: String, var sobrenomeProfessor: String, var tempoDeCasa: Int, var codigoProfessor: Int, var other: Any?){

    override fun equals(other: Any?): Boolean {
    return (other is Professor) && (codigoProfessor == other.codigoProfessor)
    }

}