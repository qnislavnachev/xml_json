package com.clouway;

import java.io.IOException;

/**
 * @author Vasil Mitov (v.mitov.clouway@gmail.com)
 */
public class App {
  public static void main(String[] args) throws IOException {
    Run Run = new Run(args);
    System.out.println(Run.compile());
  }
}
