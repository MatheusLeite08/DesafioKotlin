package br.com.DigitalHouse.DesafioKotlin

fun main(){

    var escola = DigitalHouseManager()

    //Registro dos professores
    println(" ")
    println("REGISTRO DOS PROFESSORES:")
    println(" ")
    escola.registrarProfessorTitular("Larissa", "Andrade", 10000, "Python")
    escola.registrarProfessorTitular("Nicolas", "Leite", 10001, "Kotlin")
    escola.registrarProfessorAdjunto("Gabriel", "Garcia", 10002, 5)
    escola.registrarProfessorAdjunto("Carlos", "Silva", 10003, 7)

    //Registro dos cursos
    println(" ")
    println("REGISTRO DOS CURSOS:")
    println(" ")
    escola.registrarCurso("Full Stack", 20001, 3)
    escola.registrarCurso("Android", 20002, 2)

    //Alocando os professores
    println(" ")
    println("ALOCANDO OS PROFESSORES:")
    println(" ")
    escola.alocarProfessores(20001, 10000, 10002)
    escola.alocarProfessores(20002, 10001, 10003)

    //Matriculando os alunos
    println(" ")
    println("MATRÍCULA DOS ALUNOS:")
    println(" ")
    escola.matricularAluno("Matheus", "Leite", 50001)
    escola.matricularAluno("Larissa", "Garcia", 50002)
    escola.matricularAluno("Thais", "Leles", 50003)
    escola.matricularAluno("Lucas", "Nani", 50004)
    escola.matricularAluno("Laís", "Lima", 50005)

    println(" ")
    println("MATRICULANDO OS ALUNOS NOS CURSOS:")
    println(" ")
    
    //Matriculando dois alunos no Full Stack
    escola.matricularAlunoCurso(50001, 20001)
    escola.matricularAlunoCurso(50002, 20001)

    //Matriculando três alunos no Android
    escola.matricularAlunoCurso(50003, 20002)
    escola.matricularAlunoCurso(50004, 20002)
    escola.matricularAlunoCurso(50005, 20002)

}
