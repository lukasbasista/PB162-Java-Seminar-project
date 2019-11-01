package cz.muni.fi.pb162.project;


import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for running main method.
 *
 * @author Lukáš Bašista
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {

        Vertex2D first= new Vertex2D();
        first.setX(2);
        first.setY(3);

        Vertex2D second= new Vertex2D();
        second.setX(1);
        second.setY(1);

        first.move(second);

        System.out.println(first.getInfo());
        System.out.println(second.getInfo());

    }

}
