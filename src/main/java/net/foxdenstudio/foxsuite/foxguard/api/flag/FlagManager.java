package net.foxdenstudio.foxsuite.foxguard.api.flag;

import javax.annotation.Nonnull;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class FlagManager {

    private List<Schema> schemaList = new ArrayList<>();
    private Map<String, Flag> flagMap = new HashMap<>();


    public synchronized Flag obtainFlag(String name) {
        name = name.trim().toLowerCase(Locale.ROOT);
        Flag flag;
        if (this.flagMap.containsKey(name)) {
            flag = this.flagMap.get(name);
        } else {
            flag = new Flag(name);

            this.flagMap.put(name, flag);
        }
        return flag;
    }

    public Schema obtainSchema() {
        return this.obtainSchema(-1);
    }

    public synchronized Schema obtainSchema(int id) {
        if (id < 0 || id == this.schemaList.size()) {
            Schema schema = new Schema(this.schemaList.size());
            this.schemaList.add(schema);
            return schema;
        } else {
            return this.schemaList.get(id);
        }
    }

    public void computeMapping() {
        int numSchemas = this.schemaList.size();
        for (Flag flag : this.flagMap.values()) {
            flag.schema = new int[numSchemas];
            Arrays.fill(flag.schema, -1);
        }
        for (Schema schema : this.schemaList) {
            int index = 0;
            for (Flag flag : schema.flagSet) {
                flag.schema[schema.id] = index++;
            }
        }
    }

    public static class Schema {

        public final int id;
        Set<Flag> flagSet = new LinkedHashSet<>();

        private Schema(int id) {
            this.id = id;
        }

        public Schema addFlags(@Nonnull Flag... flags) {
            this.flagSet.addAll(Arrays.asList(flags));
            return this;
        }

        public FlagSet genFlagSet(@Nonnull Flag... flags) {
            boolean[] bFlags = new boolean[this.flagSet.size()];
            for(Flag flag : flags){
                bFlags[flag.schema[this.id]] = true;
            }
            return new FlagSet(bFlags, this.id);
        }

    }

    public static class Flag {

        public final String name;

        private int[] schema;

        private Flag(String name) {
            this.name = name;
        }

        public int indexFor(int schema) {
            return this.schema[schema];
        }
    }
}
