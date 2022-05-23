package de.tum.in.ase.eist;

public class PreviewHashing extends Hashing {
    private HashFunction simpleHashAlgorithm = new SimpleHashAlgorithm();
    private static final int MAXLENGTH = 1000;
    @Override
    public String hashDocument(String s) throws IllegalArgumentException {
        if (s.length() > MAXLENGTH) {
            throw new IllegalArgumentException("This exam is too large.");
        }
        return simpleHashAlgorithm.calculateHashCode(s);
    }
    public HashFunction getImplementation() {
        return simpleHashAlgorithm;
    }
}
