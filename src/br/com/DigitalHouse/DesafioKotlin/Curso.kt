package br.com.DigitalHouse.DesafioKotlin

//PARTE B, PARTE E e PARTE H - Classe Curso
data class Curso(var nomeCurso: String, var codigoCurso: Int, var maxAlunos: Int, var professorTitular: Professor, var professorAdjunto: Professor, var listaAlunos: MutableList<Aluno>){

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (codigoCurso == other.codigoCurso)
    }

    fun adicionarUmAluno (umAluno: Aluno): Boolean{
        var numDeAlunos = listaAlunos.size

        if (numDeAlunos >= maxAlunos){
            print("- Não há vagas, ou seja, ")
            return false
        }else{
            listaAlunos.add(umAluno)
            return true
        }
    }

    fun excluirUmAluno (umAluno: Aluno){
        var indiceAluno = listaAlunos.indexOf(umAluno)

        if (indiceAluno >= 0){
            listaAlunos.removeAt(indiceAluno)
            println("- Aluno(a) ${umAluno.nomeAluno} ${umAluno.sobrenomeAluno} excluido(a) com sucesso do curso.")
        }else{
            println("- O(A) Aluno(a) ${umAluno.nomeAluno} ${umAluno.sobrenomeAluno} não está matriculado(a) nesse curso.")
        }
    }

}