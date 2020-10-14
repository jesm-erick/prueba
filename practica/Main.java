import java.util.Scanner;

import Datos.DataCarro;
import entidades.Carro;

public class Main {
    public static void main(String[] args) {
        DataCarro dataCarro = new DataCarro();
        Scanner input = new Scanner(System.in);
        int opt = 0;
        
        do {
            System.out.println("***** CRUD PERSON *****");
            System.out.println("1 List ");
            System.out.println("2 New ");
            System.out.println("3 Delete ");
            System.out.println("4 Get byID ");
            System.out.println("5 Update ");
            System.out.println("0 Exit ");
            System.out.println("Choice option: ");
            opt = input.nextInt();
            System.out.println("You chosed: " + opt);
            input.nextLine(); // Limpiar el buffer
            switch (opt) {
                case 1:
                    System.out.println("Listado de Carros ");
                    for (Carro d : dataCarro.list("")){
                        System.out.println(d.getId() + "\t" + d.getMarca() + "\t"+ d.getColor() + "\t" + d.getAge());
                    }
                    break;
                case 2:
                    System.out.println("Nueva carro ");
                    Carro p = new Carro();
                    System.out.print("Marca: ");
                    p.setMarca(input.nextLine());
                    System.out.print("Color: ");
                    p.setColor(input.nextLine());

                    System.out.print("age: ");
                    try {
                        p.setAge(input.nextInt());
                        dataCarro.create(p);
                    } catch (Exception e) {
                        input.nextLine(); // Limpiar el buffer
                        System.out.print("Ano debe ser entero, no se guardo");
                    }
                     break;
                case 3:
                System.out.println("Eliminar carro ");
                System.out.print("id: ");
                dataCarro.delete(input.nextInt());
                    break;
                case 4:
                int b4 = 1;
                    do {
                        System.out.println("get Carro ");
                        System.out.print("id: ");
                        int id = 0;
                        try {
                            b4 = 0;
                            id = input.nextInt();
                            Carro d = dataCarro.get(id);
                            if (d != null) {
                                System.out.println("Id: " + d.getId());
                                System.out.println("marca: " + d.getMarca());
                                System.out.println("color: " + d.getColor());
                                System.out.println("age: " + d.getAge());
                            } else {
                                System.out.print("el carro no existe");
                            }
                        } catch (Exception e) {
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("id no valido, debe ser un numero");
                            b4 = 1;
                        }

                    } while (b4 != 0);

                    break;
                case 5:
                    System.out.println("update carro ");
                    System.out.print("id: ");

                    Carro per = dataCarro.get(input.nextInt());

                    if (per != null) {
                        System.out.println("marca current: " + per.getMarca());
                        System.out.println("color current: " + per.getColor());
                        System.out.println("age current: " + per.getAge());

                        input.nextLine(); // Limpiar el buffer
                        System.out.print("new carro: ");
                        per.setMarca(input.nextLine());

                        System.out.print("new color: ");
                        per.setColor(input.nextLine());

                        System.out.print("edad: ");
                        try {
                            per.setAge(input.nextInt());
                            dataCarro.update(per);
                        } catch (Exception e) {
                            // per.setAge(0);
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("Edad debe ser entero, no se guardo");
                        }

                    } else {
                        System.out.println("NO encontrado");
                    }
                    break;

        
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opt != 0);
    } 
}
