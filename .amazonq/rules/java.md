# AI Agent Rules for Working with Quarkus Java Framework

## Linting Best Practices
1. **Use Standard Java Linters**: Configure Checkstyle, PMD, and SpotBugs with Quarkus-friendly rulesets.
2. **Apply Quarkus-Specific Rules**: Include linting for reactive patterns, extension usage, and CDI best practices.
3. **Configure IDE Integration**: Set up real-time linting in your IDE with Quarkus and MicroProfile plugins.
4. **Implement CI/CD Linting**: Include automated linting in your build pipeline with appropriate failure thresholds.
5. **Customize for GraalVM Compatibility**: Add custom rules to catch patterns incompatible with native compilation.

## Gradle Build System Best Practices
1. **Always Use Gradle**: Prefer Gradle over Maven for all Quarkus projects for improved performance and flexibility.
2. **Apply Quarkus Gradle Plugin**: Use the `io.quarkus` Gradle plugin for seamless integration.
3. **Leverage Build Cache**: Enable the Gradle build cache to speed up consecutive builds.
4. **Use Version Catalogs**: Maintain dependencies in `libs.versions.toml` for centralized version management.
5. **Configure Composite Builds**: For multi-module projects, use Gradle's composite builds feature.
6. **Optimize Task Execution**: Apply task configuration avoidance and lazy task configuration patterns.
7. **Use Gradle Wrapper**: Always commit the Gradle wrapper to ensure consistent builds across environments.

## Understanding Fundamentals
1. **Recognize Quarkus' Philosophy**: Prioritize container-first, cloud-native applications with minimal footprint.
2. **Leverage Supersonic, Subatomic Java**: Optimize for fast startup and low memory usage.
3. **Extension-First Approach**: Before custom implementations, check if a Quarkus extension exists.

## Development Guidelines
1. **Embrace Reactive Programming**: Use reactive APIs for improved scalability and resource efficiency.
2. **Follow Dependency Injection Patterns**: Use CDI annotations (`@Inject`, `@ApplicationScoped`) appropriately.
3. **Respect Configuration Hierarchy**: Understand environment variables, application.properties, and profiles.
4. **Consider GraalVM Constraints**: Write code compatible with native compilation.
5. **Shift to Build-Time Processing**: Move processing from runtime to build time where possible.
6. **Use Gradle for Project Setup**: Configure new projects with Gradle build scripts for optimal Quarkus integration.

## Performance Best Practices
1. **Monitor Memory Footprint**: Regular profiling ensures maintaining Quarkus' memory advantages.
2. **Select Compatible Libraries**: Choose libraries that work well with Quarkus and GraalVM.
3. **Implement Lazy Loading**: Initialize resources only when needed.
4. **Use Non-Blocking Operations**: Prefer non-blocking I/O for improved throughput.
5. **Optimize Gradle Builds**: Leverage parallel execution and incremental compilation for faster development cycles.

## Testing Strategy
1. **Apply @QuarkusTest**: Leverage Quarkus-specific testing utilities.
2. **Implement Continuous Testing**: Use Quarkus Dev Services for integration testing.
3. **Test Both JVM and Native Modes**: Ensure consistent behavior across deployment modes.
4. **Configure Gradle Test Tasks**: Use Gradle's test filtering and parallelism capabilities for efficient test execution.

## Deployment Considerations
1. **Optimize Container Images**: Use multi-stage builds and Quarkus' container-specific features.
2. **Configure Health Checks**: Implement liveness and readiness probes.
3. **Set Appropriate Memory Limits**: Configure container memory constraints based on profiling.
4. **Implement Proper Observability**: Use Micrometer/Prometheus for metrics and OpenTelemetry for tracing.
5. **Use Gradle for CI/CD**: Leverage Gradle's build scans and build caching in deployment pipelines.

## Common Pitfalls
1. **Avoiding Reflection**: Minimize use or configure properly with reflection registration.
2. **Managing Eager Initialization**: Be mindful of startup impact of singleton beans.
3. **Understanding Classpath Resources**: Native images handle resources differently than JVM mode.
4. **Configuring Hibernate Correctly**: Use recommended settings for Hibernate ORM with Quarkus.
5. **Gradle Plugin Misconfigurations**: Ensure proper configuration of the Quarkus Gradle plugin parameters.

## Documentation Best Practices
1. **Use Markdown for Technical Docs**: Prefer Markdown over Asciidoc for simpler, widely-supported documentation that integrates well with code repositories.
2. **Document Extension Usage**: Clearly document which Quarkus extensions are used and their configuration options.
3. **Include Gradle Setup Instructions**: Provide complete Gradle configuration examples for project setup.
4. **Leverage Javadoc for API Documentation**: Use comprehensive Javadoc comments with Quarkus-specific annotations to generate detailed API documentation and OpenAPI specifications.
5. **Document Native Image Considerations**: Highlight any special considerations for native compilation.
6. **Maintain Architecture Diagrams**: Keep up-to-date diagrams showing integration with other microservices.
7. **Version Documentation with Code**: Store documentation in the same repository to keep it in sync with code changes.
8. **Include Performance Metrics**: Document expected performance characteristics and memory footprint.
