package net.mcreator.rebirthinc.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.mcreator.rebirthinc.item.DrawableMapItem;
import net.mcreator.rebirthinc.network.ModNetworking;
import net.mcreator.rebirthinc.network.packet.SaveDrawingPacket;

public class DrawableMapScreen extends Screen {

    // ============================================================
    // PALETA DE CORES
    // Índice 0 = borracha (usa o fundo como cor)
    // ============================================================
    private static final int[] PALETTE = {
        0xFFEFE4B0, // 0 - Borracha
        0xFF302111, // 1 - Marrom escuro
        0xFF2637AB, // 2 - Azul
        0xFFA21626, // 3 - Vermelho
    };

    // ============================================================
    // CONFIGURAÇÕES DO CANVAS
    // ============================================================
    private static final int MAP_SIZE  = 64;
    private static final int SCALE     = 5;
    private static final int CANVAS_PX = MAP_SIZE * SCALE;

    // ============================================================
    // VARIÁVEIS DE ESTADO
    // ============================================================
    private final ItemStack      mapStack;
    private final byte[]         pixels;
    private int                  selectedColor;
    private int                  brushSize = 1;
    private int                  canvasX, canvasY;
    private final ResourceLocation penTag = new ResourceLocation("rebirth_inc", "pens");

    // ============================================================
    // CONSTRUTOR
    // Recebe a cor definida pela caneta na mão esquerda
    // ============================================================
    public DrawableMapScreen(ItemStack mapStack, int color) {
        super(Component.literal("Mapa"));
        this.mapStack      = mapStack;
        this.pixels        = DrawableMapItem.getPixels(mapStack);
        this.selectedColor = color;
    }

    // ============================================================
    // INIT
    // ============================================================
    @Override
    protected void init() {
        canvasX = (width - CANVAS_PX) / 2 - 50;
        canvasY = (height - CANVAS_PX) / 2;

        // botão fechar — salva o desenho ao fechar
        this.addRenderableWidget(
            Button.builder(Component.literal("Fechar"), btn -> {
                ModNetworking.sendToServer(new SaveDrawingPacket(pixels));
                this.onClose();
            })
            .bounds(canvasX + CANVAS_PX + 10, canvasY + CANVAS_PX - 20, 60, 20)
            .build()
        );

        // botão aumentar pincel
        this.addRenderableWidget(
            Button.builder(Component.literal("+"), btn -> brushSize = Math.min(brushSize + 1, 5))
                  .bounds(canvasX + CANVAS_PX + 10, canvasY + 240, 20, 20)
                  .build()
        );

        // botão diminuir pincel
        this.addRenderableWidget(
            Button.builder(Component.literal("-"), btn -> brushSize = Math.max(brushSize - 1, 1))
                  .bounds(canvasX + CANVAS_PX + 32, canvasY + 240, 20, 20)
                  .build()
        );
    }

    // ============================================================
    // RENDER
    // ============================================================
	@Override
	public void render(GuiGraphics gfx, int mouseX, int mouseY, float delta) {
	    renderBackground(gfx);
	
	    // --- CANVAS ---
	    gfx.fill(canvasX - 2, canvasY - 2, canvasX + CANVAS_PX + 2, canvasY + CANVAS_PX + 2, 0xFF5C3D1E);
	    gfx.fill(canvasX, canvasY, canvasX + CANVAS_PX, canvasY + CANVAS_PX, 0xFFEFE4B0);
	
	    // --- PIXELS DESENHADOS ---
	    for (int i = 0; i < pixels.length; i++) {
	        int px = i % MAP_SIZE;
	        int py = i / MAP_SIZE;
	        int colorIndex = pixels[i] & 0xFF;
	        if (colorIndex == 0) continue;
	        gfx.fill(
	            canvasX + px * SCALE,
	            canvasY + py * SCALE,
	            canvasX + px * SCALE + SCALE,
	            canvasY + py * SCALE + SCALE,
	            PALETTE[colorIndex]
	        );
	    }
	
	    // --- PALETA E PREVIEW (só se tiver caneta na mão) ---
	    ItemStack offhand = Minecraft.getInstance().player.getOffhandItem();
	    if (offhand.is(net.minecraft.tags.ItemTags.create(penTag))) {
	
	        // cor da caneta atual
	        int px = canvasX + CANVAS_PX + 10;
	        int py = canvasY;
	        gfx.fill(px - 2, py - 2, px + 22, py + 22, 0xFF000000);
	        gfx.fill(px, py, px + 20, py + 20, PALETTE[selectedColor]);
	
	        // borracha embaixo
	        int eraserPy = py + 26;
	        gfx.fill(px - 2, eraserPy - 2, px + 22, eraserPy + 22, 0xFF000000);
	        gfx.renderItem(new ItemStack(net.minecraft.world.item.Items.SPONGE), px, eraserPy);
	
	        // --- PREVIEW DO PINCEL ---
	        if (mouseX >= canvasX && mouseX < canvasX + CANVAS_PX &&
	            mouseY >= canvasY && mouseY < canvasY + CANVAS_PX) {
	
	            int pixelX = (int)(mouseX - canvasX) / SCALE;
	            int pixelY = (int)(mouseY - canvasY) / SCALE;
	
	            for (int bx = -brushSize + 1; bx < brushSize; bx++) {
	                for (int by = -brushSize + 1; by < brushSize; by++) {
	                    int fx = pixelX + bx;
	                    int fy = pixelY + by;
	                    if (fx >= 0 && fx < MAP_SIZE && fy >= 0 && fy < MAP_SIZE) {
	                        gfx.fill(
	                            canvasX + fx * SCALE,
	                            canvasY + fy * SCALE,
	                            canvasX + fx * SCALE + SCALE,
	                            canvasY + fy * SCALE + SCALE,
	                            PALETTE[selectedColor]
	                        );
	                    }
	                }
	            }
	        }
	    }
	
	    // --- TAMANHO DO PINCEL ---
	    gfx.drawString(font, "Pincel: " + brushSize, canvasX + CANVAS_PX + 10, canvasY + 265, 0xFFEFE4B0);
	
	    super.render(gfx, mouseX, mouseY, delta);
	}

    // ============================================================
    // MOUSE CLICADO
    // Esquerdo = pinta / Direito = apaga
    // ============================================================
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            // verifica clique na paleta
            ItemStack offhand = Minecraft.getInstance().player.getOffhandItem();
            if (offhand.is(net.minecraft.tags.ItemTags.create(penTag))) {
                for (int i = 0; i < PALETTE.length; i++) {
                    int px = canvasX + CANVAS_PX + 10;
                    int py = canvasY + i * 22;
                    if (mouseX >= px && mouseX <= px + 20 && mouseY >= py && mouseY <= py + 20) {
                        selectedColor = i;
                        return true;
                    }
                }
            }
            desenharNoCanvas(mouseX, mouseY, selectedColor);
        } else if (button == 1) {
            // botão direito apaga
            desenharNoCanvas(mouseX, mouseY, 0);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    // ============================================================
    // MOUSE ARRASTADO
    // Esquerdo = pinta / Direito = apaga
    // ============================================================
    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        if (button == 0) {
            desenharNoCanvas(mouseX, mouseY, selectedColor);
        } else if (button == 1) {
            desenharNoCanvas(mouseX, mouseY, 0);
        }
        return super.mouseDragged(mouseX, mouseY, button, dx, dy);
    }

    // ============================================================
    // SCROLL DO MOUSE
    // Rola pra cima = aumenta pincel / Rola pra baixo = diminui
    // ============================================================
    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (delta > 0) {
            brushSize = Math.min(brushSize + 1, 5);
        } else {
            brushSize = Math.max(brushSize - 1, 1);
        }
        return true;
    }

    // ============================================================
    // DESENHAR NO CANVAS
    // Recebe a cor como parâmetro (0 = apagar)
    // ============================================================
    private void desenharNoCanvas(double mouseX, double mouseY, int color) {
        // bloqueia se não tiver caneta na mão esquerda
        ItemStack offhand = Minecraft.getInstance().player.getOffhandItem();
        if (!offhand.is(net.minecraft.tags.ItemTags.create(penTag))) return;

        if (mouseX < canvasX || mouseX >= canvasX + CANVAS_PX) return;
        if (mouseY < canvasY || mouseY >= canvasY + CANVAS_PX) return;

        int pixelX = (int)(mouseX - canvasX) / SCALE;
        int pixelY = (int)(mouseY - canvasY) / SCALE;

        for (int bx = -brushSize + 1; bx < brushSize; bx++) {
            for (int by = -brushSize + 1; by < brushSize; by++) {
                int fx = pixelX + bx;
                int fy = pixelY + by;
                if (fx >= 0 && fx < MAP_SIZE && fy >= 0 && fy < MAP_SIZE) {
                    pixels[fy * MAP_SIZE + fx] = (byte) color;
                }
            }
        }
    }

    // ============================================================
    // NÃO PAUSA O JOGO
    // ============================================================
    @Override
    public boolean isPauseScreen() {
        return false;
    }
}