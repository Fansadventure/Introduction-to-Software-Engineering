package de.tum.in.ase.eist;

public class EnterpriseHashing extends Hashing {
    private HashFunction cryptoSecureHashAlgorithm = new CryptoSecureHashAlgorithm();
    @Override
    public String hashDocument(String s) {
        return cryptoSecureHashAlgorithm.calculateHashCode(s);
    }

    public HashFunction getImplementation() {
        return cryptoSecureHashAlgorithm;
    }
}
