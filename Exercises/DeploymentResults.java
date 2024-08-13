package InterviewPrep2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeploymentResults {
    public static void main(String[] args) {
        String deployment1 = "{\"deployment_id\": \"d-12345678ab\", \"status\": \"Success\"}";
        String deployment2 = "{\"deployment_id\": \"d-09876543cd\", \"status\": \"Failed\"}";
        String deployment3 = "{\"deployment_id\": \"d-09876543cd\", \"status\": \"ABCDE\"}";
        List<String> deployments = new ArrayList<>(List.of(deployment1, deployment2));
        List<String> deployments2 = new ArrayList<>(List.of(deployment1, deployment3));

        System.out.println(Arrays.toString(evaluate_deployments(deployments)));
        System.out.println(Arrays.toString(evaluate_deployments(deployments2)));
    }

    public static Integer[] evaluate_deployments(List<String> deployments) {
        Integer[] statusCounts = {0, 0, 0};
        List<String> deploymentHalves = new ArrayList<>();
        List<String> deploymentQuarters = new ArrayList<>();
        for(String deployment : deployments) {
            deploymentHalves = new ArrayList<>(List.of(deployment.split(",")));
            for(String deploymentHalf : deploymentHalves) {
                deploymentQuarters.addAll(List.of(deploymentHalf.split(":")));
            }
        }
        for(int i = 3; i < deploymentQuarters.size(); i += 4) {
            String deploymentStatus = deploymentQuarters.get(i);
            deploymentStatus = deploymentStatus.strip();
            if(deploymentStatus.equals("\"Success\"}")) {
                statusCounts[0]++;
            } else if (deploymentStatus.equals("\"Failed\"}")) {
                statusCounts[1]++;
            } else {
                statusCounts[2]++;
            }

        }
        return statusCounts;
    }
}
