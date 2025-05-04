# ecommerce-backend
This is a demo ecommerce website


# Observations (5th May, 2025)

If relationship mapping has the attribute "mappedBy" then @NonNull doesn't work on that, even "optional=false" also doesn't work on that.


@Autowired
Only classes with Annotation can be autowired.
When a class is annotated, java usually creates an object of it while project starts. Then if other classes autowire that class, no new object is created, rather java itself supplies that pre-created object.
But if instaed of autowiring a class creates "private final ClassName objectName" then a new object is created for this class only.


@NonNull
@Column(nullable=false)
@OneToOne(optional=false)
All the above three things do the same thing & throws an exception if found null.


If @NotNull is used in any field then the validation check is done in the DB side.
but if used @NotBlank then the validation is done before going to the DB.


@NonNull -> lombok
@NonNull -> Jakarta.annotation
@NonNull -> Spring
All above annotations can't stop the process before going to the database (In the database it get's error and returns back).
@NotBlank -> jakarta.validation.constraints.NotBlank
Only This annotation stops the process before going to the database.
{is it actually hitting the DB and getting error, or throwing error while creating the QUERY !!!!}


*** Why in a OneToOne mapping in both table the primaryKey of the other table is not stored.
It wil create recursion when fetching data.
So, at least one of the table need to stop the recursion (by not having the info of the other table).
Otherwise this will happen
User1
          Address1
                          User1
                                    Address1
                                                    User1
                                                              Address1
                                                                              ......

