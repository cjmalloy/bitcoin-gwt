package com.cjmalloy.bitcoin.client.js;

import com.google.gwt.core.client.JavaScriptObject;


public final class Transaction extends JavaScriptObject
{
    protected Transaction() {}

    /**
     * Add an input.
     *
     * @param tx
     * @param index
     */
    public native void addInput(Transaction tx, int index) /*-{

        this.addInput(tx, index);
    }-*/;

    /**
     * Add an output.
     *
     * @param address
     * @param satoshis
     */
    public native void addOutput(Address address, int satoshis) /*-{

        this.addOutput(address, satoshis);
    }-*/;

    public native Transaction clone() /*-{

        return this.clone();
    }-*/;

    public native String getId() /*-{

        return this.getId();
    }-*/;

    public native String hash() /*-{

        return this.hash();
    }-*/;

    /**
     * Hash transaction for signing a specific input.
     *
     * Bitcoin uses a different hash for each signed transaction input. This
     * method copies the transaction, makes the necessary changes based on the
     * hashType, serializes and finally hashes the result. This hash can then be
     * used to sign the transaction input in question.
     *
     * @param prevOutScript
     * @param inIndex
     * @param hashType
     * @return hash of this transaction for specific input
     */
    public native String hashForSignature(Script prevOutScript, int inIndex, int hashType) /*-{

        return this.hashForSignature(prevOutScript, inIndex, hashType);
    }-*/;

    public native void setInputScript(int index, Script script) /*-{

        this.setInputScript(index, script);
    }-*/;

    public native void sign(int index, ECKey privKey, int hashType) /*-{

        this.sign(index, privKey, hashType);
    }-*/;

    public native void signInput(int index, Script prevOutScript, ECKey privKey, int hashType) /*-{

        this.signInput(index, prevOutScript, privKey, hashType);
    }-*/;

    public native String toHex() /*-{

        return this.toHex();
    }-*/;

    public native boolean validateInput(int index, Script prevOutScript, ECPubKey pubKey, Buffer buffer) /*-{

        this.validateInput(index, prevOutScript, pubKey, buffer);
    }-*/;
}
