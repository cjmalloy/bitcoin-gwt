package com.cjmalloy.bitcoin.client;

import com.cjmalloy.bitcoin.client.js.Address;
import com.cjmalloy.bitcoin.client.js.Buffer;
import com.cjmalloy.bitcoin.client.js.ECKey;
import com.cjmalloy.bitcoin.client.js.ECPubKey;
import com.cjmalloy.bitcoin.client.js.HDNode;
import com.cjmalloy.bitcoin.client.js.Script;
import com.cjmalloy.bitcoin.client.js.Transaction;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.ScriptInjector;


public class Bitcoin
{
    private static final String BITCOIN_JS_SCRIPT = GWT.getModuleBaseForStaticFiles() + "bitcoinjs.js";

    private static Bitcoin instance = null;

    protected Bitcoin() {}

    protected native Address createAddress(Buffer hash, int version) /*-{

        return new Bitcoin.Address(hash, version);
    }-*/;

    public native Address createAddressFromBase58Check(String base58) /*-{

        return Bitcoin.Address.fromBase58Check(base58);
    }-*/;

    //TODO: Add support for other networks
    public native Address createAddressFromOutputScript(Script outputScript) /*-{

        return Bitcoin.Address.fromOutputScript(outputScript);
    }-*/;

    public native ECPubKey createECPubKeyFromHex(String hex) /*-{

        return Bitcoin.ECPubKey.fromHex(wif);
    }-*/;

    public native ECKey createECKeyFromWIF(String wif) /*-{

        return Bitcoin.ECKey.fromWIF(wif);
    }-*/;

    //TODO: Add support for custom rng
    public native ECKey createECKeyFromRandom(boolean compressed) /*-{

        return Bitcoin.ECKey.makeRandom(compressed);
    }-*/;

    protected native Script createScript(Buffer hash, JsArrayMixed chunks) /*-{

        return new Bitcoin.Script(hash, chunks);
    }-*/;

    public native Script createScriptFromAsm(String asm) /*-{

        return Bitcoin.Script.fromASM(asm);
    }-*/;

    //TODO: Add support for other networks
    public native HDNode createHDNodeFromSeedHex(String hex) /*-{

        return Bitcoin.HDNode.fromSeedHex(hex);
    }-*/;

    public native HDNode createHDNodeFromBase58(String base58) /*-{

        return Bitcoin.HDNode.fromBase58(base58);
    }-*/;

    public native HDNode createHDNodeFromHex(String hex) /*-{

        return Bitcoin.HDNode.fromHex(hex);
    }-*/;

    public native Script createScriptFromHex(String hex) /*-{

        return Bitcoin.Script.fromHex(hex);
    }-*/;

    public native Transaction createTransaction() /*-{

        return new Bitcoin.Transaction();
    }-*/;

    public native Transaction createTransactionFromHex(String hex) /*-{

        return Bitcoin.Transaction.fromHex(hex);
    }-*/;

    protected void load(final Callback<Bitcoin, Exception> callback)
    {
        ScriptInjector.fromUrl(BITCOIN_JS_SCRIPT).setCallback(new Callback<Void, Exception>()
        {
            @Override
            public void onFailure(Exception reason)
            {
                callback.onFailure(reason);
            }

            @Override
            public void onSuccess(Void result)
            {
                callback.onSuccess(instance);
            }
        }).inject();
    }

    public static void get(Callback<Bitcoin, Exception> callback)
    {
        if (instance == null)
        {
            instance = GWT.create(Bitcoin.class);
            instance.load(callback);
        }
        else
        {
            callback.onFailure(new Exception("Already loaded"));
        }
    }
}
