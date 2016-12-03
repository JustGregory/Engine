Those classfiles found in the following subdirectories are meant to be a "typical" example of an SPI (service-provider
interface) to allow distributing functionality. An SPI-based system requires implementing the core interface within an
architected module, and adding into the jar's metadata a reference to the new implementation.

To register a service-provider interface implementation within a module, find the module's `META-INF` path, and create
a text file named after the core SPI interface's fully-qualified class-path-name, and in its only line of text, add an
instance of the implementation class, also by the fully-qualified name. And, for my example of the `EngineData` class,
the file structure within the module/jar would look like this:

  engine-spi-implementing-feature.jar
    META-INF
      engine.spi.EngineData

And for that last item, it contains only one line of text, which would be some implementation classname.

  engine.spi.example.ExampleEngineData

Finally, all of the implementations must be "findable" by the ServiceLoader infrastructure. Often, it is performed from
searching through the path where the engine libraries are installed, or some named subdirectory thereof. The normal way
is using the same directory as the engine.
