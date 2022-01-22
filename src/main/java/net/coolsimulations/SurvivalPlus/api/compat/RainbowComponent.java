package net.coolsimulations.SurvivalPlus.api.compat;

import java.util.Arrays;
import java.util.List;

import net.minecraft.ChatFormatting;

/***
 * 
 * @author retrodaredevil
 * @see https://www.spigotmc.org/resources/rainbowtext-api.17709/
 *
 */
public class RainbowComponent {
	
	private int place = 0;
    private String text = "You did not provide any text.";
    private String fancyText = "\u00a74You did not provide any text";
    private static final List<ChatFormatting> RAINBOW = Arrays.asList(ChatFormatting.DARK_RED, ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.YELLOW, ChatFormatting.GREEN, ChatFormatting.DARK_GREEN, ChatFormatting.AQUA, ChatFormatting.DARK_AQUA, ChatFormatting.BLUE, ChatFormatting.DARK_BLUE, ChatFormatting.DARK_PURPLE, ChatFormatting.LIGHT_PURPLE);
    private List<ChatFormatting> rainbowArray = null;
    private String prefix = "";

    public RainbowComponent(String text) {
        if (text != null) {
            this.text = text;
        }
        if (this.rainbowArray == null) {
            this.rainbowArray = RAINBOW;
        }
        this.updateFancy();
    }

    public RainbowComponent(String text, String formatCode) {
        if (text != null) {
            this.text = text;
        }
        if (formatCode != null) {
            this.prefix = formatCode;
        }
        if (this.rainbowArray == null) {
            this.rainbowArray = RAINBOW;
        }
        this.updateFancy();
    }

    public RainbowComponent(String text, List<ChatFormatting> rainbowArray) {
        if (text != null) {
            this.text = text;
        }
        if (this.rainbowArray == null) {
            this.rainbowArray = rainbowArray;
        }
        this.updateFancy();
    }

    private void updateFancy() {
        int spot = this.place;
        String fancyText = "";
        for (char l : this.text.toCharArray()) {
            String letter = Character.toString(l);
            String t1 = fancyText;
            if (!letter.equalsIgnoreCase(" ")) {
                fancyText = String.valueOf(t1) + this.rainbowArray.get(spot) + this.prefix + letter;
                if (spot == this.rainbowArray.size() - 1) {
                    spot = 0;
                    continue;
                }
                ++spot;
                continue;
            }
            fancyText = String.valueOf(t1) + letter;
        }
        this.fancyText = fancyText;
    }

    public RainbowComponent moveRainbow() {
        this.place = this.rainbowArray.size() - 1 == this.place ? 0 : ++this.place;
        this.updateFancy();
        return this;
    }

    public RainbowComponent moveRainbowRight() {
        this.place = this.place == 0 ? this.rainbowArray.size() - 1 : --this.place;
        this.updateFancy();
        return this;
    }

    public String getOriginalText() {
        return this.text;
    }

    public String getText() {
        return this.fancyText;
    }

    public void setPlace(int place) {
        if (place > RAINBOW.size() - 1 || place < 0) {
            return;
        }
        this.place = place;
        this.updateFancy();
    }

    public int getPlace() {
        return this.place;
    }

    public List<ChatFormatting> getRainbow() {
        return this.rainbowArray;
    }

    public String getFormatPrefix() {
        return this.prefix;
    }

    public void setFormatPrefix(String prefix) {
        this.prefix = prefix;
    }

    public static List<ChatFormatting> getDefaultRainbow() {
        return RAINBOW;
    }

}
