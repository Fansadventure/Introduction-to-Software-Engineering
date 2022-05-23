package de.tum.in.ase.eist;

public abstract class Hashing {
  private HashFunction implementation = new SimpleHashAlgorithm();
  public abstract String hashDocument(String s);
  public HashFunction getImplementation() {
    return implementation;
  }
}
