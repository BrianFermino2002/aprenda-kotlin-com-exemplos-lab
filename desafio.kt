enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
        for(usuario in usuarios){
            println("Usuário ${usuario.nome} adicionado á formação $nome")
        }
    }
    
    fun adicionaConteudo(vararg conteudo: ConteudoEducacional){
        conteudos.addAll(conteudo)
        for(cont in conteudo){
        	println("O conteúdo ${cont.nome} foi adicionado á formação $nome")
        }
       
    }
    
    fun listarInscritos(){
        var i = 1
        println("Inscritos matriculados: ")
        for(inscrito in inscritos){
            println("$i - ${inscrito.nome}")
            i++
        }
    }
    
    fun listarConteudos(){
        var i = 1
        println("Conteúdos pertencentes á formação:")
        for(cont in conteudos){
            println("$i - ${cont.nome}")
            i++
        }
    }
    
    fun removerConteudo(vararg conteudo: ConteudoEducacional){
        conteudos.removeAll(conteudo)
        for(cont in conteudo){
            println("Conteudo ${cont.nome} removido da formação $nome")
        }
    }
}

fun main() {
    val java = Formacao(
        nome = "Aprenda Java em 1 hora",
    	conteudos = mutableListOf(
        	ConteudoEducacional("Variaveis", Nivel.BASICO),
            ConteudoEducacional("Estruturas de Repetição", Nivel.BASICO)
        )
    )
    
    java.matricular(Usuario("Jose"), Usuario("Andre"))
    java.matricular(Usuario("Pedro"))
    
    java.adicionaConteudo(ConteudoEducacional("Estruturas de decisão", Nivel.BASICO))
    java.adicionaConteudo(
        ConteudoEducacional("Classes Genéricas", Nivel.AVANCADO),
    	ConteudoEducacional("Funções", Nivel.INTERMEDIARIO)
    )
    
    java.listarConteudos()
    java.listarInscritos()
    
    java.removerConteudo(ConteudoEducacional("Funções", Nivel.INTERMEDIARIO))
    java.removerConteudo(
        ConteudoEducacional("Estruturas de Repetição", Nivel.BASICO),
    	ConteudoEducacional("Estruturas de decisão", Nivel.BASICO)
    )
    
    java.listarConteudos()
    java.listarInscritos()
}