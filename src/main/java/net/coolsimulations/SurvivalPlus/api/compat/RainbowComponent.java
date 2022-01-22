package net.coolsimulations.SurvivalPlus.api.compat;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.Formatting;

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
    private static final List<Formatting> RAINBOW = Arrays.asList(Formatting.DARK_RED, Formatting.RED, Formatting.GOLD, Formatting.YELLOW, Formatting.GREEN, Formatting.DARK_GREEN, Formatting.AQUA, Formatting.DARK_AQUA, Formatting.BLUE, Formatting.DARK_BLUE, Formatting.DARK_PURPLE, Formatting.LIGHT_PURPLE);
    private List<Formatting> rainbowArray = null;
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

    public RainbowComponent(String text, List<Formatting> rainbowArray) {
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
        fancyText += Formatting.RESET;
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

    public List<Formatting> getRainbow() {
        return this.rainbowArray;
    }

    public String getFormatPrefix() {
        return this.prefix;
    }

    public void setFormatPrefix(String prefix) {
        this.prefix = prefix;
    }

    public static List<Formatting> getDefaultRainbow() {
        return RAINBOW;
    }

}
