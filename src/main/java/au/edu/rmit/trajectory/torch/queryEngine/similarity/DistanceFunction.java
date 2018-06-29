package au.edu.rmit.trajectory.torch.queryEngine.similarity;

/**
 * @author forrest0402
 * @Description
 * @date 12/11/2017
 */
public interface DistanceFunction<T, U> {
    double apply(T t, U u);
}
