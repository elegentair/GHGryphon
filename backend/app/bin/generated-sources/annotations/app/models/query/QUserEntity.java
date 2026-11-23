package app.models.query;

import app.HttpInterface;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PLong;
import io.ebean.typequery.PString;
import java.util.Collection;
import org.jspecify.annotations.Nullable;

/**
 * Query bean for UserEntity.
 * <p>
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@SuppressWarnings("unused")
@io.ebean.typequery.Generated("io.ebean.querybean.generator")
@io.ebean.typequery.TypeQueryBean("v1")
public final class QUserEntity extends io.ebean.typequery.QueryBean<app.models.UserEntity,QUserEntity> {

  private static final QUserEntity _alias = new QUserEntity(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QUserEntity alias() {
    return _alias;
  }

  public PLong<QUserEntity> id;
  public PString<QUserEntity> name;
  public PString<QUserEntity> email;
  public PString<QUserEntity> imageURL;
  public PInteger<QUserEntity> grade;


  /**
   * Return a query bean used to build a FetchGroup.
   * <p>
   * FetchGroups are immutable and threadsafe and can be used by many
   * concurrent queries. We typically stored FetchGroup as a static final field.
   * <p>
   * Example creating and using a FetchGroup.
   * <pre>{@code
   * 
   * static final FetchGroup<Customer> fetchGroup = 
   *   QCustomer.forFetchGroup()
   *     .shippingAddress.fetch()
   *     .contacts.fetch()
   *     .buildFetchGroup();
   * 
   * List<Customer> customers = new QCustomer()
   *   .select(fetchGroup)
   *   .findList();
   * 
   * }</pre>
   */
  public static QUserEntity forFetchGroup() {
    return new QUserEntity(io.ebean.FetchGroup.queryFor(app.models.UserEntity.class));
  }

  /** Construct using the default Database */
  public QUserEntity() {
    super(app.models.UserEntity.class);
  }


  /** Construct with a given Database */
  public QUserEntity(io.ebean.Database database) {
    super(app.models.UserEntity.class, database);
  }


  /** Private constructor for Alias */
  private QUserEntity(boolean dummy) {
    super(dummy);
  }

  /** Private constructor for FetchGroup building */
  private QUserEntity(io.ebean.Query<app.models.UserEntity> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /** Private constructor for filterMany */
  private QUserEntity(io.ebean.ExpressionList<app.models.UserEntity> filter) {
    super(filter);
  }

  /** Return a copy of the query bean. */
  @Override
  public QUserEntity copy() {
    return new QUserEntity(query().copy());
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  public static final class Alias {
    public static PLong<QUserEntity> id = _alias.id;
    public static PString<QUserEntity> name = _alias.name;
    public static PString<QUserEntity> email = _alias.email;
    public static PString<QUserEntity> imageURL = _alias.imageURL;
    public static PInteger<QUserEntity> grade = _alias.grade;
  }

  /** Association query bean */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  @io.ebean.typequery.TypeQueryBean("v1")
  public static abstract class Assoc<R> extends io.ebean.typequery.TQAssocBean<app.models.UserEntity,R,QUserEntity> {

    public PLong<R> id;
    public PString<R> name;
    public PString<R> email;
    public PString<R> imageURL;
    public PInteger<R> grade;

    public Assoc(String name, R root) { super(name, root); }
    public Assoc(String name, R root, String prefix) { super(name, root, prefix); }
  /**
   * Is equal to by ID property.
   */
  public final R eq(HttpInterface value) {
    expr().eq(_name, value);
    return _root;
  }

  /**
   * Is equal to by ID property if the value is not null, if null no expression is added.
   */
  public final R eqIfPresent(@Nullable HttpInterface value) {
    expr().eqIfPresent(_name, value);
    return _root;
  }

  /**
   * IN the given values.
   */
  public final R in(HttpInterface... values) {
    expr().in(_name, (Object[])values);
    return _root;
  }

  /**
   * IN the given interface values.
   */
  public final R inBy(Collection<? extends HttpInterface> values) {
    expr().in(_name, values);
    return _root;
  }

  /**
   * IN the given interface values if the collection is not empty. No expression is added if the collection is empty..
   */
  public final R inOrEmptyBy(@Nullable Collection<? extends HttpInterface> values) {
    expr().inOrEmpty(_name, values);
    return _root;
  }

  }

  /** Associated ToOne query bean */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  @io.ebean.typequery.TypeQueryBean("v1")
  public static final class AssocOne<R> extends Assoc<R> {
    public AssocOne(String name, R root) { super(name, root); }
    public AssocOne(String name, R root, String prefix) { super(name, root, prefix); }
  }

  /** Associated ToMany query bean */
  @io.ebean.typequery.Generated("io.ebean.querybean.generator")
  @io.ebean.typequery.TypeQueryBean("v1")
  public static final class AssocMany<R> extends Assoc<R> implements io.ebean.typequery.TQAssocMany<app.models.UserEntity, R, QUserEntity>{
    public AssocMany(String name, R root) { super(name, root); }
    public AssocMany(String name, R root, String prefix) { super(name, root, prefix); }

    @Override
    public R filterMany(java.util.function.Consumer<QUserEntity> apply) {
      final io.ebean.ExpressionList<app.models.UserEntity> list = _newExpressionList();
      apply.accept(new QUserEntity(list));
      return _filterMany(list);
    }

    @Override
    public R filterMany(io.ebean.ExpressionList<app.models.UserEntity> filter) { return _filterMany(filter); }

    @Override
    public R filterManyRaw(String rawExpressions, Object... params) { return _filterManyRaw(rawExpressions, params); }

    @Override
    public R isEmpty() { return _isEmpty(); }

    @Override
    public R isNotEmpty() { return _isNotEmpty(); }
  }
}
