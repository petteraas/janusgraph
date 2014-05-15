package com.thinkaurelius.titan.core;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Element;

/**
 * @author Matthias Broecheler (me@matthiasb.com)
 */
public interface TitanManagement extends TitanConfiguration {

    public RelationTypeIndex createEdgeIndex(EdgeLabel label, String name, Direction direction, RelationType... sortKeys);

    public RelationTypeIndex createEdgeIndex(EdgeLabel label, String name, Direction direction, Order sortOrder, RelationType... sortKeys);

    public RelationTypeIndex createPropertyIndex(PropertyKey key, String name, RelationType... sortKeys);

    public RelationTypeIndex createPropertyIndex(PropertyKey key, String name, Order sortOrder, RelationType... sortKeys);

    public boolean containsRelationIndex(RelationType type, String name);

    public RelationTypeIndex getRelationIndex(RelationType type, String name);

    public Iterable<RelationTypeIndex> getRelationIndexes(RelationType type);


    public boolean containsGraphIndex(String name);

    public TitanGraphIndex getGraphIndex(String name);

    public Iterable<TitanGraphIndex> getGraphIndexes(final Class<? extends Element> elementType);

    public TitanGraphIndex createExternalIndex(String indexName, Class<? extends Element> elementType, String backingIndex);

    public void addIndexKey(final TitanGraphIndex index, final PropertyKey key, Parameter... parameters);

    public TitanGraphIndex createInternalIndex(String indexName, Class<? extends Element> elementType, PropertyKey... keys);

    public TitanGraphIndex createInternalIndex(String indexName, Class<? extends Element> elementType, boolean unique, PropertyKey... keys);


    public ConsistencyModifier getConsistency(TitanSchemaElement element);

    public void setConsistency(TitanSchemaElement element, ConsistencyModifier consistency);



    public boolean containsRelationType(String name);

    public RelationType getRelationType(String name);

    public PropertyKey getPropertyKey(String name);

    public EdgeLabel getEdgeLabel(String name);

    public PropertyKeyMaker makePropertyKey(String name);

    public EdgeLabelMaker makeEdgeLabel(String name);

    /**
     * Returns an iterable over all defined types that have the given clazz (either {@link EdgeLabel} which returns all labels,
     * {@link PropertyKey} which returns all keys, or {@link RelationType} which returns all types).
     *
     * @param clazz {@link RelationType} or sub-interface
     * @param <T>
     * @return Iterable over all types for the given category (label, key, or both)
     */
    public <T extends RelationType> Iterable<T> getRelationTypes(Class<T> clazz);


    public boolean containsVertexLabel(String name);

    public VertexLabel getVertexLabel(String name);

    public VertexLabelMaker makeVertexLabel(String name);


    public void commit();

    public void rollback();

    public boolean isOpen();

}
