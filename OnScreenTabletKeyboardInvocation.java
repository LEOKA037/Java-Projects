import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OnScreenTabletKeyboardInvocation {

    public static final int REG_SUCCESS = 0;
    public static final String SOFTWARE_MICROSOFT_TABLET_TIP_1_7 = "SOFTWARE\\Microsoft\\TabletTip\\1.7";
    public static final String IMMERSIVE_SHELL = "HKCU\\Software\\Microsoft\\windows\\CurrentVersion\\ImmersiveShell";
    public static final String ENABLE_DESKTOP_MODE_AUTO_INVOKE = "EnableDesktopModeAutoInvoke";
    public static final String DISABLE_NEW_KEYBOARD_EXPERIENCE = "DisableNewKeyboardExperience";
    public static final String TABLET_MODE = "TabletMode";
    public static final String REG_VALUE = "1";
    public static final String VALUE_CREATED = "value created";
    public static final String ERROR_COULD_NOT_CREATE_THE_VALUE = "Error: could not create the value";

    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String... args) {

        OnScreenTabletKeyboardInvocation reg = new OnScreenTabletKeyboardInvocation();

        try {
            addRegistryValuesForTabTip(reg);
            invokeTabTip();
        } catch (InterruptedException | IOException e) {
            logger.warning("An error occurred. " + e.getMessage());
        }
    }

    private static void invokeTabTip() throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "start \"\" \"C:\\Program Files\\Common Files\\microsoft shared\\ink\\TabTip.exe\"");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        logger.info(String.valueOf(p.pid()));
    }

    private static void addRegistryValuesForTabTip(OnScreenTabletKeyboardInvocation reg) throws IOException, InterruptedException {

        //Adding the required Registry entries for enabling Tablet keyboard invocation value TabTip
        Map<String, String> dWordMap = new HashMap<>();
        dWordMap.put(SOFTWARE_MICROSOFT_TABLET_TIP_1_7, ENABLE_DESKTOP_MODE_AUTO_INVOKE);
        dWordMap.put(SOFTWARE_MICROSOFT_TABLET_TIP_1_7, DISABLE_NEW_KEYBOARD_EXPERIENCE);
        dWordMap.put(IMMERSIVE_SHELL, TABLET_MODE);

        for (Map.Entry<String, String> entry : dWordMap.entrySet()) {
            if (reg.addValue(WRKey.HKCU, entry.getKey(), entry.getValue(), REG_VALUE.getBytes(), WRType.REG_DWORD)) {
                logger.info(VALUE_CREATED);
            } else {
                logger.warning(ERROR_COULD_NOT_CREATE_THE_VALUE);
            }
        }
    }

    public String createRegString(WRKey hkey, String key, String valueName, byte[] data, WRType type, boolean force) {
        String keyString = " " + hkey + "\\" + key;
        String valueString = valueName != null ? " /v " + valueName : "";
        String dataString = data != null ? (" " + (data.length > 0 ? " /d " + new String(data) : "")) : "";
        String typeString = type != null ? " /t " + type : "";
        return keyString + valueString + dataString + typeString + (force ? " /f" : "");
    }

    public boolean addValue(WRKey hkey, String key, String valueName, byte[] data, WRType type) throws IOException, InterruptedException {
        String regString = createRegString(hkey, key, valueName, data, type, true);
        Process proc = Runtime.getRuntime().exec("REG ADD " + regString);
        proc.waitFor();
        return proc.exitValue() == REG_SUCCESS;
    }

    private enum WRKey {
        HKLM, HKCU, HKCR, HKU, HKCC
    }

    private enum WRType {
        REG_SZ, REG_MULTI_SZ, REG_EXPAND_SZ,
        REG_DWORD, REG_QWORD, REG_BINARY, REG_NONE
    }

}