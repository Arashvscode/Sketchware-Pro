package mod.tyron.compiler;

import java.io.File;
import java.util.ArrayList;

import a.a.a.zy;

public abstract class Compiler {

    public static final int TYPE_JAVA = 10;
    public static final int TYPE_D8 = 11;
    public static final int TYPE_MERGE = 13;
    public static final int TYPE_APK = 12;


    /**
     * Interface for communicating between different compiler
     *
     * The first argument SHOULD BE a string
     */
    public interface Result {
        void onResult(boolean success, int compileType, Object... args);
    }

    abstract public ArrayList<?> getSourceFiles();

    abstract public void compile();
}
