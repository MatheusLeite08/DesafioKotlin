package br.com.DigitalHouse.DesafioKotlin

//PARTE G e PARTE I - Classe DigitalHouseManager
class DigitalHouseManager (var listaAlunos: MutableList<Aluno> = mutableListOf(), var listaProfessores: MutableList<Professor> = mutableListOf(), var listaCursos: MutableList<Curso> = mutableListOf(),var listaMatriculas: MutableList<Matricula> = mutableListOf()){

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int){
        var professorTitularGenerico = Professor(" ", " ", 0, 0, " ")
        var professorAdjuntoGenerico = Professor(" ", " ", 0, 0, 0)
        var listaAlunos = mutableListOf<Aluno>()

        var curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos, professorTitularGenerico, professorAdjuntoGenerico, listaAlunos)
        listaCursos.add(curso)
        println("- O curso ${curso.nomeCurso} foi registrado com sucesso.")
    }

    fun excluirCurso(codigoCurso: Int){
        var profTitularGenerico = Professor(" "," ", 0, 0," ")
        var profAdjuntoGenerico = Professor(" ", " ", 0, 0, 0)
        var listaGenerica = mutableListOf<Aluno>()
        var cursoSendoExcluido = Curso(" ", codigoCurso, 0, profTitularGenerico, profAdjuntoGenerico, listaGenerica)

        for (curso in listaCursos){
            if (curso.equals(cursoSendoExcluido)){
                println("- O curso ${curso.nomeCurso} foi excluido com sucesso.")
                var i = listaCursos.indexOf(curso)
                listaCursos.removeAt(i)
                return
            }
        }
        println("- O curso de código ${codigoCurso} não foi encontrado.")
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int){
        var professorAdjunto = Professor(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        listaProfessores.add(professorAdjunto)
        println("- O(A) Professor(a) Adjunto(a) ${professorAdjunto.nomeProfessor} ${professorAdjunto.sobrenomeProfessor} foi registrado(a) com sucesso.")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
        var professorTitular = Professor(nome, sobrenome, 0, codigoProfessor, especialidade)
        listaProfessores.add(professorTitular)
        println("- O(A) Professor(a) Titular ${professorTitular.nomeProfessor} ${professorTitular.sobrenomeProfessor} foi registrado(a) com sucesso.")
    }

    fun excluirProfessor(codigoProfessor: Int){
        var professorSendoExcluido = Professor(" ", " ", 0, codigoProfessor, " ")

        for (professor in listaProfessores){
            if (professor.equals(professorSendoExcluido)){
                println("- O(A) Professor(a) ${professor.nomeProfessor} ${professor.sobrenomeProfessor} foi excluido(a) com sucesso.")
                var i = listaProfessores.indexOf(professor)
                listaProfessores.removeAt(i)
                return
            }
        }
        println("- O(A) Professor(a) de código ${codigoProfessor} não foi encontrado encontrado")
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int){
        var aluno = Aluno (nome, sobrenome, codigoAluno)
        listaAlunos.add(aluno)
        println("- O(A) Aluno(a) ${aluno.nomeAluno} ${aluno.sobrenomeAluno} foi matriculado(a) com sucesso.")
    }

    fun matricularAlunoCurso(codigoAluno: Int, codigoCurso: Int){
        var profTitularGenerico = Professor(" "," ", 0, 0," ")
        var profAdjuntoGenerico = Professor(" ", " ", 0, 0, 0)
        var listaGenerica = mutableListOf<Aluno>()
        var cursoDestino = Curso(" ", codigoCurso, 0, profTitularGenerico, profAdjuntoGenerico, listaGenerica)
        var alunoSendoMatriculado = Aluno(" ", " ", codigoAluno)
        var flagCurso = false
        var flagAluno = false

        for (curso in listaCursos){
            if (curso.equals(cursoDestino)){
                cursoDestino = curso
                flagCurso = true
            }
        }

        for (aluno in listaAlunos){
            if (aluno.equals(alunoSendoMatriculado)){
                alunoSendoMatriculado = aluno
                flagAluno = true
            }
        }

        if ((cursoDestino.adicionarUmAluno(alunoSendoMatriculado)) && flagAluno && flagCurso){
            var matricula = Matricula(alunoSendoMatriculado, cursoDestino)
            listaMatriculas.add(matricula)
            println("- O(A) Aluno(a) ${alunoSendoMatriculado.nomeAluno} ${alunoSendoMatriculado.sobrenomeAluno} foi matriculado(a) com sucesso no curso ${cursoDestino.nomeCurso}.")
        }else{
            println("não é possível realizar a matrícula do(a) Aluno(a) ${alunoSendoMatriculado.nomeAluno} ${alunoSendoMatriculado.sobrenomeAluno} no curso ${cursoDestino.nomeCurso}.")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        var profTitular = Professor(" "," ", 0, codigoProfessorTitular," ")
        var profAdjunto = Professor(" ", " ", 0, codigoProfessorAdjunto, 0)
        var listaGenerica = mutableListOf<Aluno>()
        var cursoDestino = Curso(" ", codigoCurso, 0, profTitular, profAdjunto, listaGenerica)
        var flagCurso = false
        var flagProfTitular = false
        var flagProfAdjunto = false

        for (professor in listaProfessores){
            if (professor.equals(profTitular)){
                profTitular = professor
                flagProfTitular = true
            }
        }

        for (professor in listaProfessores){
            if (professor.equals(profAdjunto)){
                profAdjunto = professor
                flagProfAdjunto = true
            }
        }

        for (curso in listaCursos){
            if (curso.equals(cursoDestino)){
                cursoDestino = curso
                flagCurso = true
            }
        }

        if (flagCurso && flagProfAdjunto && flagProfTitular){
            cursoDestino.professorTitular = profTitular
            cursoDestino.professorAdjunto = profAdjunto
            println("- O(A) Professor(a) Titular ${profTitular.nomeProfessor} ${profTitular.sobrenomeProfessor} e o(a) Professor(a) Adjunto(a) ${profAdjunto.nomeProfessor} ${profAdjunto.sobrenomeProfessor} foram alocados(as) com sucesso no curso ${cursoDestino.nomeCurso}.")
        }else{
            println("- Não foi possível alocar os(as) professores(as).")
        }
    }
}
