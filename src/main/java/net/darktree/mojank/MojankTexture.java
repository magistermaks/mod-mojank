package net.darktree.mojank;

import net.minecraft.client.resource.metadata.TextureResourceMetadata;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStream;

public class MojankTexture extends ResourceTexture {

    public MojankTexture(Identifier location) {
        super(location);
    }

    protected TextureData loadTextureData(ResourceManager resourceManager) {
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mojank.png");

            TextureData var6;
            try {
                var6 = new TextureData(new TextureResourceMetadata(true, true), NativeImage.read(inputStream));
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }

            return var6;
        } catch (IOException var18) {
            return new TextureData(var18);
        }
    }

}
