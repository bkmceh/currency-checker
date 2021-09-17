package inforest.currencychecker.model.gif.response;

public class BrokeGifResponse extends AbstractGifResponse {

    private byte[] gifData;

    @Override
    public byte[] getGif() {
        return gifData;
    }

    public void setGif(final byte[] gif) {
        this.gifData = gif;
    }
}
