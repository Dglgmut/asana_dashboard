[:h1 {:class "header"} (str "Welcome to asana dashboard, " (:name *view-context*))]

[:p (str "total tasks points: " (:total-tasks-points *view-context*))]

[:p (str "total completed tasks points: " (:total-completed-tasks-points *view-context*))]
