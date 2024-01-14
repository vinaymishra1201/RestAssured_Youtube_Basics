package channing;

import java.util.List;

public class CreateUserResponse {
    private List<UserData> data;

    public int getUserId() {
        if (data != null && !data.isEmpty()) {
            return data.get(0).getId(); // Assuming the ID is in the first element of the array
        } else {
            throw new IllegalStateException("User data is empty or null");
        }
    }

    private static class UserData {
        private int id;

        public int getId() {
            return id;
        }
    }
}
