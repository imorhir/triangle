/* 
 * Assignment: #2
 * Topic: Identifying Triangles
 * Author: <YOUR NAME>
 */

package edu.depaul.triangle;

import static edu.depaul.triangle.TriangleType.EQUILATERAL;
import static edu.depaul.triangle.TriangleType.ISOSCELES;
import static edu.depaul.triangle.TriangleType.SCALENE;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class to classify a set of side lengths as one of the 3 types
 * of triangle: equilateral, isosceles, or scalene.
 *
 * Throws an IllegalArgumentException if the input cannot be interpreted
 * as a triangle for any reason.
 */
public class Triangle {

  private static final Logger logger = LoggerFactory.getLogger(Triangle.class);
  private int[] sides = new int[3];
  
  /**
   * Define as private so that it is not a valid
   * choice.

   */
  private Triangle() {}
  
  public Triangle(String[] args) {
    validateArgs(args);

    parseArgs(args);

    validateLength();
  }

  private void parseArgs(String[] args) {
    // throws IllegalArgumentException on a failed parse
    for (int i = 0; i < args.length; i++) {
      sides[i] = Integer.parseInt(args[i]);
    }
  }

  private void validateArgs(String[] args) {
    if ((args == null) || (args.length != 3)) {
      throw new IllegalArgumentException("Must have 3 elements");
    }
  }

  public TriangleType classify() {
    TriangleType result;
    if ((sides[0] == sides[1]) && (sides[1] == sides[2])) {
      result = EQUILATERAL;
    } else if ((sides[0] == sides[1]) 
        || (sides[1] == sides[2])) {
      result = ISOSCELES;
    } else {
      result = SCALENE;
    }
    logger.debug("classified as: " + result);
    return result;
  }

  private void validateLength() {
    for (int i = 0; i < sides.length; i++) {
      if (sides[i] > 500) {
        throw new IllegalArgumentException("max size is 300");
      }
    }
  }
  
  private static String[] getArgs(Scanner s) {
    System.out.println("press Enter by itself to quit");
    System.out.println("enter 3 integers separated by space.");
    String args = s.nextLine();
    return args.split(" ");
  }
  
  public static void main(String[] a) {
    try (Scanner scanner = new Scanner(System.in)) {
      String[] args = getArgs(scanner);
      while (args[0].length() != 0) {
        try {
          Triangle t = new Triangle(args);
          TriangleType triClass = t.classify();
          System.out.println("Triangle type: " + triClass);
        } catch (IllegalArgumentException e) {
          logger.error("Invalid input: " + e.getMessage());
        }
        args = getArgs(scanner);
      }
      System.out.println("Done");
    }
  }
}
