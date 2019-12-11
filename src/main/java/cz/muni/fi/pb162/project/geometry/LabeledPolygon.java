package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Lukáš Bašista
 */
public final class LabeledPolygon extends SimplePolygon {
    private Map<String,Vertex2D> map;
    /**
     * Constructor
     *
     * @param map Array of object
     */
    private LabeledPolygon(Map<String, Vertex2D> map) {
        this.map = map;
    }

    @Override
    public Vertex2D getVertex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Index cannot be lower than zero.");
        }
        Vertex2D[] ar = map.values().toArray(new Vertex2D[map.size()]);
        return ar[index % map.size()];
    }

    @Override
    public int getNumVertices() {
        return map.size();
    }

    /**
     *
     * @param label label
     * @return Vertex
     */
    public Vertex2D getVertex(String label){
        if (!map.containsKey(label)) {
            throw new NullPointerException("label");
        }
        return map.get(label);
    }

    public Map<String, Vertex2D> getLabeledPolygon(){
        return Collections.unmodifiableMap(map);
    }

    /**
     *
     * @return Labels
     */
    public Collection<String> getLabels() {
        if (map.keySet().isEmpty()) {
            throw new NullPointerException();
        }
        return Collections.unmodifiableSet(map.keySet());
    }

    /**
     *
     * @param vert Vertex2D
     * @return labels
     */
    public Collection<String> getLabels(Vertex2D vert) {
        Collection<String> labels = new ArrayList<>();
        Iterator<Map.Entry<String,Vertex2D>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String,Vertex2D> entry = entries.next();
            Vertex2D v=getVertex(entry.getKey());
            if(v.equals(vert)) {
                labels.add(entry.getKey());
            }
        }
        return Collections.unmodifiableCollection(labels);
    }

    /**
     *
     * @return sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices() {
        List<Vertex2D> sorted= new ArrayList<>();
        for(int i=0; i<map.size(); i++) {
            if(!sorted.contains(getVertex(i))) {
                sorted.add(getVertex(i));
            }
        }

        int size=sorted.size();
        Collection<Vertex2D> ret=new ArrayList<Vertex2D>();
        for(int i=0; i<size; i++) {
            Vertex2D min=sorted.get(0);
            for(int j=0; j<sorted.size(); j++) {
                if(min.compareTo(sorted.get(j))>0) {
                    min = sorted.get(j);
                }
            }
            ret.add(min);
            sorted.remove(min);
        }
        return Collections.unmodifiableCollection(ret);
    }

    /**
     *
     * @param comparator comparator
     * @return sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        SortedSet<Vertex2D> values = new TreeSet<>(comparator);
        values.addAll(map.values());
        return values;
    }

    /**
     *
     * @return duplicate vertices
     */
    public Collection<Vertex2D> duplicateVertices() {
        Set<Vertex2D> duplicateVertices = new HashSet<>();
        for(Vertex2D v : map.values()) {
            if(Collections.frequency(map.values(), v) > 1) {
                duplicateVertices.add(v);
            }
        }
        return duplicateVertices;
    }

    /**
     * @author Lukáš Bašista
     */
    public static class Builder implements Buildable {
        private Map<String, Vertex2D> buildMap = new HashMap<>();

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(this.buildMap);
        }

        /**
         *
         * @param label String
         * @param vert Vertex2D
         * @return LabeledPolygon
         * @throws IllegalArgumentException if vertex/label is null
         */
        public Builder addVertex(String label, Vertex2D vert) throws IllegalArgumentException {
            if(label==null) {
                throw new IllegalArgumentException("label is null!");
            }
            if(vert==null) {
                throw new IllegalArgumentException("vertex is null!");
            }
            this.buildMap.put(label, vert);
            return this;
        }
    }
}

