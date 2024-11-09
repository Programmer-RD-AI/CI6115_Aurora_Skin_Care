from graphviz import Digraph

# Create a new UML diagram with enhanced visual settings
uml_diagram = Digraph('K2434232_Enhanced_UML_Class_Diagram', filename='./Final_Enhanced_UML_Diagram.png', format='png')

# Global graph settings for better visualization
uml_diagram.attr(
    rankdir='TB',
    splines='ortho',
    nodesep='1.0',
    ranksep='1.2',
    concentrate='true',
    compound='true',
    fontname='Arial',
    dpi='300',
    pad='0.5'
)

# Define node attributes for cleaner look
uml_diagram.attr('node',
                 shape='record',
                 style='filled',
                 fillcolor='white',
                 fontname='Arial',
                 fontsize='10',
                 margin='0.3,0.1',
                 height='0.5'
                 )

# Define edge attributes for cleaner look
uml_diagram.attr('edge',
                 fontname='Arial',
                 fontsize='8',
                 len='1.5',
                 splines='ortho'
                 )

# Create subgraphs for each layer for better organization
with uml_diagram.subgraph(name='cluster_0') as view_layer:
    view_layer.attr(label='Presentation Layer', style='rounded', color='#2C3E50')

    # View Classes
    view_layer.node('K2434232_AppointmentView', '{K2434232_AppointmentView|scanner: Scanner\\lappointmentController: AppointmentController\\lpatientView: PatientView\\ldermatologistView: DermatologistView\\ltreatmentView: TreatmentView\\ltimeView: TimeView\\linvoiceView: InvoiceView\\l|showAppointmentMenu(): void\\ldisplayMenu(): void\\lgetUserChoice(): int\\lscheduleAppointment(): void\\lviewAllAppointments(): void\\lupdateAppointment(): void\\lcancelAppointment(): void\\lcompleteAppointment(): void\\lprocessInvoicePayment(): void\\lsearchAppointment(): void\\l}')

    view_layer.node('K2434232_PatientView', '{K2434232_PatientView||getPatientDetails(): Patient\\l}')

    view_layer.node('K2434232_DermatologistView', '{K2434232_DermatologistView|scanner: Scanner\\ldermatologistService: DermatologistService\\l|selectDermatologist(): DermatologistModel\\laddTimeSlotForDermatologist(): void\\lgetValidDateFromUser(): LocalDate\\lgetValidStartTimeFromUser(): LocalTime\\l}')

    view_layer.node('K2434232_TreatmentView', '{K2434232_TreatmentView||getTreatmentDetails(): Treatment\\l}')

    view_layer.node('K2434232_TimeView', '{K2434232_TimeView||getTimeDetails(dermatologist: DermatologistModel): Time\\l}')

    view_layer.node('K2434232_InvoiceView', '{K2434232_InvoiceView||getInvoiceDetails(treatment: Treatment): Invoice\\l}')

with uml_diagram.subgraph(name='cluster_1') as service_layer:
    service_layer.attr(label='Service Layer', style='rounded', color='#2980B9')

    # Service Classes
    service_layer.node('K2434232_AppointmentService', '{K2434232_AppointmentService|appointmentRepository: AppointmentRepository\\l|createAppointment(appointment: Appointment): void\\llistAppointments(): List<Appointment>\\lupdateAppointment(appointment: Appointment): boolean\\lcancelAppointment(appointmentId: int): boolean\\lcompleteAppointment(appointmentId: int): boolean\\lsearchAppointments(criteria: String): List<Appointment>\\l}')

    service_layer.node('K2434232_DermatologistService', '{K2434232_DermatologistService|dermatologistRepository: DermatologistRepository\\l|selectDermatologist(): DermatologistModel\\laddTimeSlotForDermatologist(dermatologist: DermatologistModel, time: Time): boolean\\lgetDermatologistAvailability(dermatologistId: int, date: LocalDate): List<Time>\\l}')

    service_layer.node('K2434232_PatientService', '{K2434232_PatientService|patientRepository: PatientRepository\\l|getPatientDetails(patientId: int): Patient\\lcreatePatient(patient: Patient): void\\lupdatePatient(patient: Patient): boolean\\l}')

with uml_diagram.subgraph(name='cluster_2') as repository_layer:
    repository_layer.attr(label='Repository Layer', style='rounded', color='#27AE60')

    # Repository Classes
    repository_layer.node('K2434232_AppointmentRepository', '{K2434232_AppointmentRepository|appointments: List<Appointment>\\l|save(appointment: Appointment): void\\lfindAll(): List<Appointment>\\lfindById(appointmentId: int): Optional<Appointment>\\ldelete(appointmentId: int): boolean\\lupdate(appointment: Appointment): boolean\\l}')

    repository_layer.node('K2434232_DermatologistRepository', '{K2434232_DermatologistRepository|dermatologists: List<DermatologistModel>\\l|save(dermatologist: DermatologistModel): void\\lfindAll(): List<DermatologistModel>\\lfindById(id: int): Optional<DermatologistModel>\\laddTimeSlot(dermatologist: DermatologistModel, time: Time): boolean\\l}')

    repository_layer.node('K2434232_PatientRepository', '{K2434232_PatientRepository|patients: List<Patient>\\l|save(patient: Patient): void\\lfindAll(): List<Patient>\\lfindById(id: int): Optional<Patient>\\l}')

with uml_diagram.subgraph(name='cluster_3') as domain_layer:
    domain_layer.attr(label='Domain Layer', style='rounded', color='#8E44AD')

    # Domain Model Classes
    domain_layer.node('K2434232_Appointment', '{K2434232_Appointment|appointmentId: int\\lpatient: Patient\\ldermatologist: DermatologistModel\\ltreatment: Treatment\\ltime: Time\\linvoice: Invoice\\lstatus: AppointmentStatus\\l|setStatus(status: AppointmentStatus): void\\lgetInvoice(): Invoice\\lgetId(): int\\l}')

    domain_layer.node('K2434232_Patient', '{K2434232_Patient|patientId: int\\lname: String\\lage: int\\lcontactInfo: String\\lmedicalHistory: String\\l|getId(): int\\lgetName(): String\\lgetAge(): int\\l}')

    domain_layer.node('K2434232_DermatologistModel', '{K2434232_DermatologistModel|dermatologistId: int\\lname: String\\lspecialization: String\\lavailableTimeSlots: List<Time>\\l|checkAvailability(time: Time): boolean\\laddTimeSlot(time: Time): void\\l}')

    domain_layer.node('K2434232_Treatment', '{K2434232_Treatment|treatmentId: int\\lname: String\\ldescription: String\\lduration: int\\lcost: double\\l|getCost(): double\\lgetDuration(): int\\l}')

    domain_layer.node('K2434232_Invoice', '{K2434232_Invoice|invoiceId: int\\ltotalAmount: double\\lamountPaid: double\\lstatus: PaymentStatus\\l|makePayment(amount: double): void\\lisPaid(): boolean\\lgetBalance(): double\\l}')

    domain_layer.node('K2434232_Time', '{K2434232_Time|date: LocalDate\\lstartTime: LocalTime\\lendTime: LocalTime\\l|getDate(): LocalDate\\lgetStartTime(): LocalTime\\lgetEndTime(): LocalTime\\lisAvailable(): boolean\\l}')

# Add relationships with better edge styling
# View to Service Layer relationships
uml_diagram.edge('AppointmentView', 'AppointmentService', 'uses', dir='forward', arrowhead='vee')
uml_diagram.edge('DermatologistView', 'DermatologistService', 'uses', dir='forward', arrowhead='vee')
uml_diagram.edge('PatientView', 'PatientService', 'uses', dir='forward', arrowhead='vee')

# Service to Repository Layer relationships
uml_diagram.edge('AppointmentService', 'AppointmentRepository', 'uses', dir='forward', arrowhead='vee')
uml_diagram.edge('DermatologistService', 'DermatologistRepository', 'uses', dir='forward', arrowhead='vee')
uml_diagram.edge('PatientService', 'PatientRepository', 'uses', dir='forward', arrowhead='vee')

# Domain Model relationships
uml_diagram.edge('Appointment', 'Patient', 'contains', dir='both', arrowtail='odiamond')
uml_diagram.edge('Appointment', 'DermatologistModel', 'contains', dir='both', arrowtail='odiamond')
uml_diagram.edge('Appointment', 'Treatment', 'contains', dir='both', arrowtail='odiamond')
uml_diagram.edge('Appointment', 'Time', 'contains', dir='both', arrowtail='odiamond')
uml_diagram.edge('Appointment', 'Invoice', 'owns', dir='both', arrowtail='diamond')

# Repository to Domain Model relationships
uml_diagram.edge('AppointmentRepository', 'Appointment', 'manages', style='dashed', dir='forward')
uml_diagram.edge('DermatologistRepository', 'DermatologistModel', 'manages', style='dashed', dir='forward')
uml_diagram.edge('PatientRepository', 'Patient', 'manages', style='dashed', dir='forward')

# Generate the diagram
uml_diagram.render(view=True)