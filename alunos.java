import java.util.*;

record Aluno(int matricula, double[] notas) {
    public double mediaNotas(){
        return Arrays.stream(notas).average().orElse(Double.NaN);
    }
}

public class Program {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList();
        int matricula = 0;
        double[] notas = { 0, 0, 0 };
        Scanner stdin = new Scanner(System.in);
        do{
            System.out.println("Matricula: ");
            matricula = Integer.parseInt(stdin.nextLine());
            for(int i = 1; i < 4; i++){
                System.out.format("Nota %d: ", i);
                notas[i - 1] = Double.parseDouble(stdin.nextLine());
            }
            alunos.add(new Aluno(matricula, notas));
        }while(matricula != 999);
        for(Aluno aluno : alunos){
            String status = switch(aluno.mediaNotas()){
                case double d && d > 6 -> "Aprovado";
                case double d && d < 4 -> "Reprovado";
                default -> "Realizar prova final";
            };
            System.out.format("Matricula: %d, Status: %s", aluno.matricula(), status);
        }
    }
}
