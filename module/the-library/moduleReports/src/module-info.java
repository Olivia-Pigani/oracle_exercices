module moduleReports {
    requires transitive moduleInventory;
    requires moduleBookApi;
    exports report;
}