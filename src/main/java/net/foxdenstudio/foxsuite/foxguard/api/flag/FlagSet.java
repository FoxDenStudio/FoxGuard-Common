package net.foxdenstudio.foxsuite.foxguard.api.flag;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class FlagSet {

    private final boolean[] flags;
    private final int schema; // 0 is root schema

    int hash; // 0
    boolean zeroHash; // false

    public FlagSet(@Nonnull boolean[] flags) {
        this(flags, 0);
    }

    public FlagSet(@Nonnull boolean[] flags, int schema) {
        this.flags = flags;
        this.schema = schema;
    }

    public FlagSet(@Nonnull FlagSet flagSet) {
        this.flags = Arrays.copyOf(flagSet.flags, flagSet.flags.length);
        this.schema = flagSet.schema;
        this.hash = flagSet.hash;
        this.zeroHash = flagSet.zeroHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlagSet flagSet = (FlagSet) o;
        return Arrays.equals(flags, flagSet.flags);
    }

    @Override
    public int hashCode() {
        int h = hash;
        if (h == 0 && !zeroHash) {
            h = Arrays.hashCode(flags);
            if (h == 0) {
                zeroHash = true;
            } else {
                hash = h;
            }
        }
        return h;
    }

}
